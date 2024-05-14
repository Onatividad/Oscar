package com.practicando.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Detalles_pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    private Pedidos pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Productos producto;
    
    private Double precio_unidad;
    private int unidades;
    private Double total;
}
