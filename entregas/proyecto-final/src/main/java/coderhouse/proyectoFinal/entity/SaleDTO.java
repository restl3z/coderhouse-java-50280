package coderhouse.proyectoFinal.entity;

import lombok.Getter;

import java.util.List;

@Getter
public class SaleDTO {

    private Long userID;

    private List<Long> productIDs;

    private int quantity;

    private double totalAmount;

    public SaleDTO(Long userID, List<Long> productIDs, int quantity, double totalAmount) {
        this.userID = userID;
        this.productIDs = productIDs;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }
}
