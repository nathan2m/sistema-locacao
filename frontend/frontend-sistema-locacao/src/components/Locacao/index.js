import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import api from '../../services/api';
import FormRow from './FormRow';
import TableRow from './TableRow';

const methods = require('../functions');

function Index() {
    const [locacoes, setLocacoes] = useState([]);

    useEffect(() => {
        const getLocacoes = async () => {
            await api.get('/Locacao')
                .then(response => {
                    setLocacoes(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }

        getLocacoes();
    }, []);

    return (
        <>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 corpo">
                    <h1>Pesquisa de Locações</h1>
                </div>
                <div className="col-sm-2"></div>
            </div>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 text-left corpo">
                    <div className="tabela">
                        <table className="table table-striped table-condensed table-responsive table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Id Locação</th>
                                    <th>Nome Cliente</th>
                                    <th>Título Filme</th>
                                    <th>Data Locação</th>
                                    <th>Data Devolução</th>
                                    <th colSpan="3">Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                {locacoes.map((locacao, i) => <TableRow obj={locacao} key={i} />)}
                            </tbody>
                        </table>
                    </div>
                    <Link to={'/locacao/cadastrar'} className="btn btn-default">Cadastrar Locação</Link>
                </div>
                <div className="col-sm-2"></div>
            </div>
        </>
    )
};

function Cadastrar() {

    const inicialLocacao = {
        idCliente: '',
        dataLocacao: '',
        dataDevolucao: '',
        idFilme: '',
    }

    const [locacao, setLocacao] = useState(inicialLocacao);

    const handleChange = event => {
        setLocacao({ locacao: methods.changeStateObj(event, locacao) });
    }

    const history = useNavigate();
    const handleSubmit = async () => {
        await api.post('/Locacao', locacao)
            .then(res => {
                console.log(res.data)
                history('/locacao');
            })
            .catch(function (error) {
                console.log(error);
            })
    }

    return (
        <FormRow
            obj={locacao}
            operacao={"Cadastrar"}
            handleChange={handleChange}
            onSubmit={handleSubmit}
        />
    )
}

function Consultar() {
    const inicialLocacao = {
        idCliente: '',
        dataLocacao: '',
        dataDevolucao: '',
        idFilme: '',
    }

    const [locacao, setLocacao] = useState(inicialLocacao);
    const { id } = useParams();

    useEffect(() => {
        const getLocacao = async () => {
            await api.get(`/Locacao/${id}`)
                .then(response => {
                    setLocacao(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getLocacao();
    }, [id]);

    return (
        <FormRow
            obj={locacao}
            operacao={"Consultar"}
        />
    )
}

function Atualizar() {
    const inicialLocacao = {
        idCliente: '',
        dataLocacao: '',
        dataDevolucao: '',
        idFilme: '',
    }

    const [locacao, setLocacao] = useState(inicialLocacao);
    const handleChange = event => {
        setLocacao({ locacao: methods.changeStateObj(event, locacao) });
    }
    
    const { id } = useParams();

    useEffect(() => {
        const getLocacao = async () => {
            await api.get(`/Locacao/${id}`)
                .then(response => {
                    setLocacao(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getLocacao();
    }, [id]);

    const history = useNavigate();
    const handleSubmit = async () => {
        await api.put('/Locacao', locacao)
            .then(res => {
                console.log(res.data)
                history('/locacao');
            })
            .catch(function (error) {
                console.log(error);
            })
    }
    
    return (
        <FormRow
            obj={locacao}
            operacao={"Atualizar"}
            handleChange={handleChange}
            onSubmit={handleSubmit}
        />
    )
}

function Excluir() {
    const inicialLocacao = {
        idCliente: '',
        dataLocacao: '',
        dataDevolucao: '',
        idFilme: '',
    }

    const [locacao, setLocacao] = useState(inicialLocacao);
    const { id } = useParams();

    useEffect(() => {
        const getLocacao = async () => {
            await api.get(`/Locacao/${id}`)
                .then(response => {
                    setLocacao(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getLocacao();
    }, [id]);

    const history = useNavigate();
    const handleSubmit = async () => {
        await api.delete(`/Locacao/${id}`)
            .then(res => {
                console.log(res.data)
                history('/locacao');
            })
            .catch(function (error) {
                console.log(error);
            })
    }
    
    return (
        <FormRow
            obj={locacao}
            operacao={"Excluir"}
            onSubmit={handleSubmit}
        />
    )
}

const exportedObject = {
    Index, Cadastrar, Consultar, Atualizar, Excluir
};

export default exportedObject;