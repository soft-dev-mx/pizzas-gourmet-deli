package com.ampeliodev.pizzasgourmetdeliapirest.service.serviceproductos;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainproductos.EntidadProductos;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoproductos.DtoEntidadProductos;
import com.ampeliodev.pizzasgourmetdeliapirest.repository.repositoryproductos.IDaoProductos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service

public class ServiceProductosImplements implements IServiceProductos {

    @Autowired
    private IDaoProductos daoProductos;

    @Autowired
    private ServiceProductosImg serviceProductosImg;

    @Override
    @Transactional(readOnly = true)
    public List<DtoEntidadProductos> listarProductos(){

        return daoProductos.findAll()
                .stream()
                .map(producto -> new DtoEntidadProductos(
                        producto.getIdProducto(),
                        producto.getNombreProducto(),
                        producto.getCategoriaProducto(),
                        producto.getClaveProducto(),
                        producto.getPrecioProductoMini(),
                        producto.getPrecioProductoIndividual(),
                        producto.getPrecioProductoChica(),
                        producto.getPrecioProductoMediana(),
                        producto.getPrecioProductoGrande(),
                        producto.getPrecioProductoFamiliar(),
                        producto.getPrecioProductoOtros(),
                        producto.getDescripcionProducto(),
                        producto.getImagenProducto()
                )).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DtoEntidadProductos guardarProductos(DtoEntidadProductos dtoProductos, MultipartFile imagenProducto) throws IOException {

        EntidadProductos entidadProducto = new EntidadProductos();
        entidadProducto.setNombreProducto(dtoProductos.getNombreProducto());
        entidadProducto.setCategoriaProducto(dtoProductos.getCategoriaProducto());

        int largoBaseDatos = (int) daoProductos.count();
        String categoriaProducto = entidadProducto.getCategoriaProducto();
        int claveProducto = 0;
        if(categoriaProducto.equals("tradicionales-clasicas")){
            claveProducto = 1001 + largoBaseDatos;
        } else if(categoriaProducto.equals("tradicionales-especiales")){
            claveProducto = 2001 + largoBaseDatos;
        } else if(categoriaProducto.equals("gourmet-clasicas")){
            claveProducto = 3001 + largoBaseDatos;
        } else if(categoriaProducto.equals("gourmet-especiales")){
            claveProducto = 4001 + largoBaseDatos;
        }
        entidadProducto.setClaveProducto(claveProducto);
        entidadProducto.setPrecioProductoMini(dtoProductos.getPrecioProductoMini());
        entidadProducto.setPrecioProductoIndividual(dtoProductos.getPrecioProductoIndividual());
        entidadProducto.setPrecioProductoChica(dtoProductos.getPrecioProductoChica());
        entidadProducto.setPrecioProductoMediana(dtoProductos.getPrecioProductoMediana());
        entidadProducto.setPrecioProductoGrande(dtoProductos.getPrecioProductoGrande());
        entidadProducto.setPrecioProductoFamiliar(dtoProductos.getPrecioProductoFamiliar());
        double precioProductoOtros = 0;
        entidadProducto.setPrecioProductoOtros(precioProductoOtros);
        entidadProducto.setDescripcionProducto(dtoProductos.getDescripcionProducto());

        String imagenProductoService = serviceProductosImg.guardarImagen(imagenProducto);
        dtoProductos.setImagenProducto(imagenProductoService);
        entidadProducto.setImagenProducto(imagenProductoService);


        daoProductos.save(entidadProducto);
        return dtoProductos;
    }

    @Override
    @Transactional
    public void eliminarProducto(EntidadProductos producto){
        daoProductos.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public EntidadProductos encontrarProducto(EntidadProductos producto){
        return daoProductos.findById(producto.getIdProducto()).orElse(null);
    }
}
