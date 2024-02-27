package coderhouse.proyectoFinal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sale")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToMany
    @JoinTable(name = "sale_item", joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))

    private List<ProductModel> products;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_amount")
    private double totalAmount;
}
