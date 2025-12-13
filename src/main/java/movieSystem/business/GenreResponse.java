package movieSystem.business;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreResponse {

    private List<GenreTest> genres;
}
