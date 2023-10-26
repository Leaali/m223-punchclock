package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    @Transactional
    public void deleteEntry(Long id){
        Entry entry = entityManager.find(Entry.class, id);
        entityManager.remove(entry);
        return;
    }
    @Transactional
    public Entry updateEntry(Long id, Entry entry){
        entry.setId(id);
        // Man könnte hier testen, ob die ID übereinstimmen
        return entityManager.merge(entry);
    }

    
    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class); //von tabelle entry 
        return query.getResultList();
    }
}
