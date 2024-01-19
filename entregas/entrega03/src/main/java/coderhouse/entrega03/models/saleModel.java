package coderhouse.entrega03.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class saleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productID")
    private Long productID;

    @Column(name = "productName")
    private String productName;

    @Column(name = "userID")
    private Long userID;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userEmail")
    private String userEmail;
}
