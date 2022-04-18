import React, { useEffect, useState } from 'react';
import api from '../../services/api';

function FormRow(props) {

    const { idCliente, dataLocacaoFormatado, dataDevolucaoFormatado, idFilme } = props.obj;
    const operacao = props.operacao;

    const [clientes, setClientes] = useState([]);
    const [filmes, setFilmes] = useState([]);

    useEffect(() => {
        const getClientes = async () => {
            await api.get('/Cliente')
                .then(response => {
                    setClientes(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getClientes();

        const getFilmes = async () => {
            await api.get('/Filme')
                .then(response => {
                    setFilmes(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getFilmes();
    }, []);

    return (
        <>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 corpo">
                    <h1>{operacao} Locação</h1>
                </div>
                <div className="col-sm-2"></div>
            </div>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 text-left corpo">
                    <form>
                        <div className="form-group">
                            <label>Cliente: </label>
                            <select
                                disabled={!props.handleChange}
                                className="form-control"
                                defaultValue={idCliente}
                                onChange={props.handleChange}
                            >
                                <option disabled value="0"> </option>
                                {clientes.map((cliente, i) => (
                                    <option key={i} value={cliente.id}>{cliente.nome}</option>
                                ))}
                            </select>
                        </div>
                        <div className="form-group">
                            <label>Filme: </label>
                            <select
                                disabled={!props.handleChange}
                                className="form-control"
                                defaultValue={idFilme}
                                onChange={props.handleChange}
                            >
                                <option disabled value="0"> </option>
                                {filmes.map((filme, i) => (
                                    <option key={i} value={filme.id}>{filme.titulo}</option>
                                ))}
                            </select>
                        </div>
                        <div className="form-group">
                            <label>Data de Locação:</label>
                            <input
                                type="date"
                                className="form-control"
                                defaultValue={dataLocacaoFormatado}
                                onChange={props.handleChange}
                                readOnly={!props.handleChange}
                            />
                        </div>
                        {
                            operacao !== "Cadastrar" ?
                                <div className="form-group">
                                    <label>Data de Devolução:</label>
                                    <input
                                        type="date"
                                        className="form-control"
                                        defaultValue={dataDevolucaoFormatado}
                                        onChange={props.handleChange}
                                        readOnly={!props.handleChange}
                                    />
                                </div>
                                : <></>
                        }

                        {
                            operacao !== "Consultar" ?
                                <input
                                    type="submit"
                                    className="btn btn-default"
                                    value={`${operacao} locação`}
                                /> : <></>
                        }
                    </form>
                </div>
                <div className="col-sm-2 "></div>
            </div >
        </>
    )
}

export default FormRow;