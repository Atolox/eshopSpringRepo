package eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
