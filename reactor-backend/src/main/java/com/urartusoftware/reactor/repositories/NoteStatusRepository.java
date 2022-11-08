package com.urartusoftware.reactor.repositories;

import com.urartusoftware.reactor.daos.NoteStatusDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteStatusRepository extends JpaRepository<NoteStatusDAO, Integer> {
}
