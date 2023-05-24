package com.propig_backend.propig.service;

import com.propig_backend.propig.exceptions.CotaNotFound;
import com.propig_backend.propig.models.PedidoPost;
import com.propig_backend.propig.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PostRepository postRepository;

    public PedidoPost savePost (PedidoPost pedidoPost){
        postRepository.save(pedidoPost);
        System.out.println(pedidoPost.toString());
        return pedidoPost;
    }

    public PedidoPost find (Long id) throws CotaNotFound {
        Optional<PedidoPost> produtoPost = postRepository.findById(id);
        return  produtoPost.orElseThrow(()-> new CotaNotFound());
    }

    public PedidoPost updatePost (PedidoPost pedidoPost) throws CotaNotFound{
        find(pedidoPost.getId());
        postRepository.save(pedidoPost);
        return pedidoPost;
    }
    public void deletePost (Long id){
        postRepository.deleteById(id);
    }
}
