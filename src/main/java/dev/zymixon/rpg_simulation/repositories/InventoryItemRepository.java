package dev.zymixon.rpg_simulation.repositories;

import dev.zymixon.rpg_simulation.entities.items.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
}
