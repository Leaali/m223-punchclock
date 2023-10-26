package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "category") //auf tabelle entry gibt es ein feld welches category heisst, dort sehen alle entries zu dieser kategorie
    @JsonIgnoreProperties("category") // macht das man nicht eine endlose schleife hat
    private Set<Entry> entries;




    //GETTER SETTER
    public Set<Entry> getEntries() {
        return entries;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
