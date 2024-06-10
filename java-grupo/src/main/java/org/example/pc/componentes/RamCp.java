package org.example.pc.componentes;
import com.github.britooo.looca.api.core.Looca;
import org.example.Conexao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.RowSet;
import java.sql.ResultSet;
import java.util.List;

public class RamCp extends Componente {

//    private Memoria memoria;

    public RamCp(Integer fkMaquina) {
        super(fkMaquina);
//        this.memoria = new Memoria();
    }
//
//    public Memoria getMemoria() {
//        return memoria;
//    }

    @Override
    public void buscarInfosFixos() {

        Looca looca = new Looca();

        Conexao con = new Conexao();

        Long totalMemoria = (looca.getMemoria().getTotal() / 1000000000);

        String queryMemoria = """
                    INSERT INTO dadosFixos VALUES
                                            (null, %d, 2, 'total de memoria do computador', '%s', 'total de memoria do computador')
                """.formatted(
                fkMaquina,
                totalMemoria
        );

        con.executarQuery(queryMemoria);

    }

    @Override
    public void buscarInfosVariaveis() {

        Looca looca = new Looca();
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();


        Long emUsoMemoria = (looca.getMemoria().getEmUso() / 1000000000);


        try{
            String queryFk = """
                    select idDadosFixos from dadosFixos where fkMaquina = %d and fkTipoComponente = 2""".formatted(fkMaquina);
            System.out.println(queryFk);
            Integer fk = con.queryForObject(queryFk,Integer.class);
            System.out.println(fk);

        var queryMemoria= """
                    iNSERT INTO dadosTempoReal VALUES  (null, %d, %d, 2, current_timestamp(),'emUso', '%s');
                           """.formatted(
                fk,
                fkMaquina,
                emUsoMemoria
        );

        conexao.executarQuery(queryMemoria);
        }catch (Exception erro){
            System.out.println(erro);
        }


    }

    @Override
    public void atualizarFixos() {

        Looca looca = new Looca();
        Conexao con = new Conexao();

        Long totalMemoria = (looca.getMemoria().getTotal() / 1000000000);


        String sql21 = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'total de memoria do computador';
                """.formatted(
                totalMemoria,
                fkMaquina,
                2);

        con.executarQuery(sql21);

    }
}
