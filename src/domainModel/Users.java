package domainModel;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Users{
    private int id;
    private String username;
    private String password;
}
