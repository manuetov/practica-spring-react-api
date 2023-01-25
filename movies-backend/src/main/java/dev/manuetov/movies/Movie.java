package dev.manuetov.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies") //
@Data // anotación de Lombok para los getters, setters y String métodos
@AllArgsConstructor // de Lombok para los métodos constructores para que
                    // tomen las private properties
@NoArgsConstructor // constructores sin atributos/propiedades
public class Movie {
    @Id // clave primaria ObjectId
   private ObjectId id;
   private String imdbId;
   private String title;
   private String releaseDate;
   private String trailerLink;
   private String poster;
   private List<String> genres;
   private List<String> backdrops;

   @DocumentReference
   private List<Review> reviewIds;

}


