package ee.bcs.myApp.bank.service.statement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatementResponse {

    private List<Statement> statements;


}
