package com.propig_backend.propig.repository;

import com.propig_backend.propig.models.PedidoPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository  extends JpaRepository<PedidoPost, Long> {
}
