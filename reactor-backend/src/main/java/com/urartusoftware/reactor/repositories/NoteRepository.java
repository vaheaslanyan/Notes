package com.urartusoftware.reactor.repositories;

import com.urartusoftware.reactor.daos.NoteDAO;
import com.urartusoftware.reactor.daos.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<NoteDAO, Integer> {
    public Optional<List<NoteDAO>> findByUserIdOrderByTimestampDesc(int userId);
}
