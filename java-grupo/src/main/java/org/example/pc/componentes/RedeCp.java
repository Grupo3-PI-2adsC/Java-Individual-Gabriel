package org.example.pc.componentes;

import com.github.britooo.looca.api.core.Looca;
import org.example.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RedeCp extends Componente {

    public RedeCp(Integer fkMaquina) {
        super(fkMaquina);
    }

    @Override
    public void buscarInfosFixos() {

        Looca looca = new Looca();
        Conexao con = new Conexao();

        String nomeRede = looca.getRede().getParametros().getNomeDeDominio();
        String nomeExibicaoRede = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getNomeExibicao();
        List enderecoIPv4Rede = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoIpv4();
        List enderecoIPv6Rede = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoIpv6();
        String enderecoMACRede = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoMac();
        String hostnameRede = looca.getRede().getParametros().getHostName();
        List servidoresDNSRede = looca.getRede().getParametros().getServidoresDns();

        String queryRede = """
                    INSERT INTO fixosRede VALUES
                                            (null, %d, 'Nome da rede', '%s'),
                                            (null, %d, 'Nome de exibição da rede', '%s'),
                                            (null, %d, 'Endereço IPv4 da rede', '%s'),
                                            (null, %d, 'Endereço IPv6 da rede', '%s'),
                                            (null, %d, 'Endereço MAC da rede', '%s'),
                                            (null, %d, 'hostname da rede', '%s'),
                                            (null, %d, 'servidores DNS da rede', '%s')
                """.formatted(
                fkMaquina,
                nomeRede,
                fkMaquina,
                nomeExibicaoRede,
                fkMaquina,
                enderecoIPv4Rede,
                fkMaquina,
                enderecoIPv6Rede,
                fkMaquina,
                enderecoMACRede,
                fkMaquina,
                hostnameRede,
                fkMaquina,
                servidoresDNSRede
        );

        con.executarQuery(queryRede);

    }


    @Override
    public void buscarInfosVariaveis() {

        System.out.println("aisdpasindpas");
        Looca looca = new Looca();
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        Long pacotesRecebidosRede = (looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getPacotesRecebidos());
        Long pacotesEnviadosRede = (looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getPacotesEnviados());
        String host = looca.getRede().getParametros().getHostName();
        try {

            String queryFk = """
                    select idFixosRede from fixosRede where fkMaquina = 1 and nomeCampo = '%s'""".formatted(fkMaquina, host);
            System.out.println(queryFk);
            Integer fk = con.queryForObject(queryFk, Integer.class);
            System.out.println(fk);


            var queryRede = """
                    iNSERT INTO variaveisRede VALUES  (null, %d, 4, current_timestamp(),'Pacotes recebidos', '%s'),
                                                       (null, %d, 4, current_timestamp(),'Pacotes enviados', '%s');
                           """.formatted(
                    fkMaquina,
                    pacotesRecebidosRede,
                    fkMaquina,
                    pacotesEnviadosRede
            );
            conexao.executarQuery(queryRede);
        }catch (Exception erro){
            System.out.println(erro);
        }
    }


    @Override
    public void atualizarFixos() {

        Looca looca = new Looca();
        Conexao con =  new Conexao();

        String nomeRede = looca.getRede().getParametros().getNomeDeDominio();
        String nomeExibicaoRede = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getNomeExibicao();
        List enderecoIPv4Rede = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoIpv4();
        List enderecoIPv6Rede = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoIpv6();
        String enderecoMACRede = looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoMac();
        String hostnameRede = looca.getRede().getParametros().getHostName();
        List servidoresDNSRede = looca.getRede().getParametros().getServidoresDns();



        String sql9 = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'servidores DNS da rede';
                """.formatted(
                servidoresDNSRede,
                fkMaquina,
                4);

        con.executarQuery(sql9);

        String sql10 = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'hostname da rede';
                """.formatted(
                hostnameRede,
                fkMaquina,
                4);

        con.executarQuery(sql10);

        String sql11 = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'Endereço MAC da rede';
                """.formatted(
                enderecoMACRede,
                fkMaquina,
                4);

        con.executarQuery(sql11);

        String sql12 = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'Endereço IPv6 da rede';
                """.formatted(
                enderecoIPv6Rede,
                fkMaquina,
                4);

        con.executarQuery(sql12);

        String sql13 = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'Endereço IPv4 da rede';
                """.formatted(
                enderecoIPv4Rede,
                fkMaquina,
                4);

        con.executarQuery(sql13);

        String sql14 = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'enderecoIPv4';
                """.formatted(
                nomeExibicaoRede,
                fkMaquina,
                4);

        con.executarQuery(sql14);

        String sql15 = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'Nome de exibição da rede';
                """.formatted(
                nomeExibicaoRede,
                fkMaquina,
                4);

        con.executarQuery(sql15);

        String sql16 = """
                
                UPDATE dadosFixos SET valorCampo = '%s' where fkMaquina = '%d' and fkTipoComponente = '%d' and nomeCampo = 'Nome da rede';
                """.formatted(
                nomeRede,
                fkMaquina,
                4);

        con.executarQuery(sql16);

    }


}
