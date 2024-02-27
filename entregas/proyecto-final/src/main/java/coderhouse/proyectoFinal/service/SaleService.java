package coderhouse.proyectoFinal.service;

import coderhouse.proyectoFinal.entity.ProductModel;
import coderhouse.proyectoFinal.entity.SaleDTO;
import coderhouse.proyectoFinal.entity.SaleModel;
import coderhouse.proyectoFinal.entity.UserModel;
import coderhouse.proyectoFinal.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public List<SaleModel> getSales() {
        return saleRepository.findAll();
    }

    public SaleModel addSale(SaleDTO sale) {

        Optional<UserModel> foundUser = userService.getUserByID(sale.getUserID());

        List<Long> productIDs = sale.getProductIDs();

        List<ProductModel> saleItems = productService.getProductByIDs(productIDs);

        double total = saleItems.stream().mapToDouble(ProductModel::getPrice).sum();

        LocalDateTime date = getDate();

        SaleModel newSale = new SaleModel();

        newSale.setUser(foundUser.get());
        newSale.setProducts(saleItems);
        newSale.setDate(date);
        newSale.setQuantity(sale.getProductIDs().size());
        newSale.setTotalAmount(total);

        return saleRepository.save(newSale);
    }

    public Optional<SaleModel> getSaleByID(Long id) {
        return saleRepository.findById(id);
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    private LocalDateTime getDate() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://worldclockapi.com/api/json/utc/now"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            return LocalDateTime.parse(responseBody.substring(7, responseBody.length() - 2), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (Exception e) {
            return LocalDateTime.now();
        }
    }
}
