import React, { useEffect, useState } from "react";
import api from '../../services/api';

function Relatorio() {
    const dataHoje = new Date().toLocaleDateString();

    const [clientesAtraso, setClientesAtraso] = useState([]);
    const [filmesNuncaAlugados, setFilmesNuncaAlugados] = useState([]);
    const [filmesMaisAlugados, setFilmesMaisAlugados] = useState([]);
    const [filmesMenosAlugados, setFilmesMenosAlugados] = useState([]);
    const [locacoesCliente, setLocacoesCliente] = useState([]);

    useEffect(() => {
        const getClientesAtraso = async () => {
            await api.get('/Relatorio/clientes_atraso_devolucao')
                .then(response => {
                    setClientesAtraso(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getClientesAtraso();

        const getFilmesNuncaAlugados = async () => {
            await api.get('/Relatorio/filmes_nunca_alugados')
                .then(response => {
                    setFilmesNuncaAlugados(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getFilmesNuncaAlugados();

        const getFilmesMaisAlugados = async () => {
            await api.get('/Relatorio/filmes_mais_alugados')
                .then(response => {
                    setFilmesMaisAlugados(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getFilmesMaisAlugados();

        const getFilmesMenosAlugados = async () => {
            await api.get('/Relatorio/filmes_menos_alugados')
                .then(response => {
                    setFilmesMenosAlugados(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getFilmesMenosAlugados();

        const getLocacoesCliente = async () => {
            await api.get('/Relatorio/cliente_mais_alugou_filmes')
                .then(response => {
                    setLocacoesCliente(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getLocacoesCliente();
    }, []);

    return (
        <>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 corpo">
                    <h1>Relat??rios</h1> Data de hoje: {dataHoje}
                </div>
                <div className="col-sm-2"></div>
            </div>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 text-left corpo">
                    <b>Clientes em atraso na devolu????o:</b>
                    <div className="tabela">
                        <table className="table table-striped table-condensed table-responsive table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Id Cliente</th>
                                    <th>Nome Cliente</th>
                                </tr>
                            </thead>
                            <tbody>
                                {clientesAtraso.map((cliente, i) => {
                                    return (
                                        <tr key={i}>
                                            <td>{cliente.id}</td>
                                            <td>{cliente.nome}</td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
                <div className="col-sm-2"></div>
            </div>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 text-left corpo">
                    <b>Filmes que nunca foram alugados:</b>
                    <div className="tabela">
                        <table className="table table-striped table-condensed table-responsive table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Id Filme</th>
                                    <th>T??tulo Filme</th>
                                </tr>
                            </thead>
                            <tbody>
                                {filmesNuncaAlugados.map((filme, i) => {
                                    return (
                                        <tr key={i}>
                                            <td>{filme.id}</td>
                                            <td>{filme.titulo}</td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
                <div className="col-sm-2"></div>
            </div>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 text-left corpo">
                    <b>Cinco filmes mais alugados do ??ltimo ano:</b>
                    <div className="tabela">
                        <table className="table table-striped table-condensed table-responsive table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Id Filme</th>
                                    <th>T??tulo Filme</th>
                                </tr>
                            </thead>
                            <tbody>
                                {filmesMaisAlugados.map((filme, i) => {
                                    return (
                                        <tr key={i}>
                                            <td>{filme.id}</td>
                                            <td>{filme.titulo}</td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
                <div className="col-sm-2"></div>
            </div>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 text-left corpo">
                    <b>Tr??s filmes menos alugados da ??ltima semana:</b>
                    <div className="tabela">
                        <table className="table table-striped table-condensed table-responsive table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Id Filme</th>
                                    <th>T??tulo Filme</th>
                                </tr>
                            </thead>
                            <tbody>
                                {filmesMenosAlugados.map((filme, i) => {
                                    return (
                                        <tr key={i}>
                                            <td>{filme.id}</td>
                                            <td>{filme.titulo}</td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
                <div className="col-sm-2"></div>
            </div>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 text-left corpo">
                    <b>O segundo cliente que mais alugou filmes:</b>
                    <div className="tabela">
                        <table className="table table-striped table-condensed table-responsive table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Id Loca????o</th>
                                    <th>Nome Cliente</th>
                                    <th>T??tulo Filme</th>
                                    <th>Data Loca????o</th>
                                    <th>Data Devolu????o</th>
                                </tr>
                            </thead>
                            <tbody>
                                {locacoesCliente.map((locacao, i) => {
                                    return (
                                        <tr key={i}>
                                            <td>{locacao.id}</td>
                                            <td>{locacao.cliente.nome}</td>
                                            <td>{locacao.filme.titulo}</td>
                                            <td>{locacao.dataLocacaoFormatado}</td>
                                            <td>{locacao.dataDevolucaoFormatado}</td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
                <div className="col-sm-2"></div>
            </div>
        </>
    )
}

export default Relatorio;