package course.springdata.springdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Account extends BaseEntity {
    @NonNull
    private BigDecimal balance;
    @ManyToOne
    @ToString.Exclude
    private User user = new User();
}
