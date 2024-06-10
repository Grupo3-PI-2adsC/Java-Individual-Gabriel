package org.example.pc.componentes;

import com.github.britooo.looca.api.core.Looca;
import org.example.Conexao;

import java.time.Instant;

public class SistemaCp extends Componente {
    public SistemaCp(Integer fkMaquina) {
        super(fkMaquina);
    }

    @Override
    public void buscarInfosFixos() {

        Looca looca = new Looca();
        Conexao con = new Conexao();

        //            SISTEMA
        String modeloSistema = looca.getRede().getParametros().getHostName();
        Instant inicializadoSistema = looca.getSistema().getInicializado();

        String querySistema = """
                    INSERT INTO dadosFixos VALUES
                                            (null, %d, 1, 'modelo do Sistema', '%s', 'modelo do Sistema'),
                                            (null, %d, 1, 'inicialização do sistema', '%s', 'inicialização do sistema');
                """.formatted(
                fkMaquina,
                modeloSistema,
                fkMaquina,
                inicializadoSistema
        );

        con.executarQuery(querySistema);
    }

    @Override
    public void buscarInfosVariaveis() {

    }

    @Override
    public void atualizarFixos() {

        Looca looca = new Looca();
        Conexao con = new Conexao();

        String modeloSistema = looca.getRede().getParametros().getHostName();
        Instant inicializadoSistema = looca.getSistema().getInicializado();


        String sql = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'modelo do Sistema';
        
                """.formatted(
                modeloSistema,
                fkMaquina,
                1

        );

        con.executarQuery(sql);

        String sql22 = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'inicialização do sistema';
                """.formatted(
                inicializadoSistema,
                fkMaquina,
                1);

        con.executarQuery(sql22);

    }
}
