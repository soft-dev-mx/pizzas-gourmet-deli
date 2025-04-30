package com.ampeliodev.pizzasgourmetdeliapirest.service.serviceproductos;

import com.ampeliodev.pizzasgourmetdeliapirest.domain.domainproductos.EntidadProductos;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoproductos.DtoEntidadProductos;
import com.ampeliodev.pizzasgourmetdeliapirest.dto.dtoproductos.DtoEntidadProductosResponse;
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
    public List<DtoEntidadProductosResponse> listarProductos(){

        return daoProductos.findAll()
                .stream()
                .map(producto -> new DtoEntidadProductosResponse(
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
    @Transactional(readOnly = true)
    public List<DtoEntidadProductosResponse> listarProductosCategoria(String categoriaProducto1, String categoriaProducto2){
        return daoProductos.listarPorCategoria(categoriaProducto1, categoriaProducto2)
                .stream()
                .map(producto -> new DtoEntidadProductosResponse(
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
    @Transactional(readOnly = true)
    public List<DtoEntidadProductosResponse> listarProductosPorUnaCategoria(String categoriaProducto1){
        return daoProductos.listarPorUnaCategoria(categoriaProducto1)
                .stream()
                .map(producto -> new DtoEntidadProductosResponse(
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
    public DtoEntidadProductos guardarProductosPizza(DtoEntidadProductos dtoProductos, MultipartFile imagenProducto) throws IOException {

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

        entidadProducto.setImagenProducto(imagenProductoService);

        daoProductos.save(entidadProducto);
        return dtoProductos;
    }

    @Override
    @Transactional
    public DtoEntidadProductos guardarProductosOtros(DtoEntidadProductos dtoProductos, MultipartFile imagenProducto) throws IOException {

        EntidadProductos entidadProducto = new EntidadProductos();
        entidadProducto.setNombreProducto(dtoProductos.getNombreProducto());
        entidadProducto.setCategoriaProducto(dtoProductos.getCategoriaProducto());

        int largoBaseDatos = (int) daoProductos.count();
        String categoriaProducto = entidadProducto.getCategoriaProducto();
        int claveProducto = 0;
        if(categoriaProducto.equals("bebidas")){
            claveProducto = 5001 + largoBaseDatos;
        } else if(categoriaProducto.equals("complementos")){
            claveProducto = 6001 + largoBaseDatos;
        } else if(categoriaProducto.equals("postres")){
            claveProducto = 7001 + largoBaseDatos;
        }

        entidadProducto.setClaveProducto(claveProducto);

        double precioProductoMini = 0;
        entidadProducto.setPrecioProductoMini(precioProductoMini);
        double precioProductoIndividual = 0;
        entidadProducto.setPrecioProductoIndividual(precioProductoIndividual);
        double precioProductoChica = 0;
        entidadProducto.setPrecioProductoChica(precioProductoChica);
        double precioProductoMediana = 0;
        entidadProducto.setPrecioProductoMediana(precioProductoMediana);
        double precioProductoGrande = 0;
        entidadProducto.setPrecioProductoGrande(precioProductoGrande);
        double precioProductoFamiliar = 0;
        entidadProducto.setPrecioProductoFamiliar(precioProductoFamiliar);
        entidadProducto.setPrecioProductoOtros(dtoProductos.getPrecioProductoOtros());
        entidadProducto.setDescripcionProducto(dtoProductos.getDescripcionProducto());

        String imagenProductoService = serviceProductosImg.guardarImagen(imagenProducto);

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
