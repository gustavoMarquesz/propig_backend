package com.propig_backend.propig.controllers;


import com.propig_backend.propig.models.PedidoPost;
import com.propig_backend.propig.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/posts")

public class ProdutoPostControler {
    @Autowired
    PedidoService pedidoService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save (@RequestBody PedidoPost pedidoPost){
        pedidoPost = pedidoService.savePost(pedidoPost);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedidoPost.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value =  "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id){
        PedidoPost pedidoPost = pedidoService.find(id);
        return  ResponseEntity.ok().body(pedidoPost);
    }

    @RequestMapping(value =  "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Void> update(@RequestBody PedidoPost pedidoPost, @PathVariable Long id){
        pedidoPost.setId(id);
        pedidoPost = pedidoService.updatePost(pedidoPost);
        return  ResponseEntity.noContent().build();
    }

    @RequestMapping(value =  "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        pedidoService.deletePost(id);
        return  ResponseEntity.noContent().build();
    }

}
