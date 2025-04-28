package com.ampeliodev.pizzasgourmetdeliapirest.service.serviceproductos;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainproductos.EntidadProductos;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoproductos.DtoEntidadProductos;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoproductos.DtoEntidadProductosResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceProductos {

    public List<DtoEntidadProductosResponse> listarProductos();

    public List<DtoEntidadProductosResponse> listarProductosCategoria(String categoriaProducto1, String categoriaProducto2);

    public List<DtoEntidadProductosResponse> listarProductosPorUnaCategoria(String categoriaProducto1);

    public DtoEntidadProductos guardarProductosPizza(DtoEntidadProductos dtoProducto, MultipartFile archivoImagen) throws IOException;

    public DtoEntidadProductos guardarProductosOtros(DtoEntidadProductos dtoProducto, MultipartFile archivoImagen) throws IOException;

    public void eliminarProducto(EntidadProductos producto);

    public EntidadProductos encontrarProducto(EntidadProductos producto);

}
