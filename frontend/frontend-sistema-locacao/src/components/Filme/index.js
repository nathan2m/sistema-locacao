import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import api from '../../services/api';
import FormRow from './FormRow';
import TableRow from './TableRow';

const methods = require('../functions');

function Index() {
    const [filmes, setFilmes] = useState([]);

    useEffect(() => {
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
                    <h1>Pesquisa de Filmes</h1>
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
                                    <th>Id Filme</th>
                                    <th>Título Filme</th>
                                    <th colSpan="3">Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                {filmes.map((filme, i) => <TableRow obj={filme} key={i} />)}
                            </tbody>
                        </table>
                    </div>
                    <Link to={'/filme/cadastrar'} className="btn btn-default">Cadastrar Filme</Link>
                </div>
                <div className="col-sm-2"></div>
            </div>
        </>
    );
};


function Cadastrar() {
    const inicialFilme = {
        classificacaoIndicativa: '',
        lancamento: '',
        titulo: '',
    }

    const [filme, setFilme] = useState(inicialFilme);

    const handleChange = event => {
        setFilme({ filme: methods.changeStateObj(event, filme) });
    }

    const history = useNavigate();
    const handleSubmit = async () => {
        await api.post('/Filme', filme)
            .then(res => {
                console.log(res.data)
                history('/filme');
            })
            .catch(function (error) {
                console.log(error);
            })
    }

    return (
        <FormRow
            obj={filme}
            operacao={"Cadastrar"}
            handleChange={handleChange}
            onSubmit={handleSubmit}
        />
    )
}

function Consultar() {
    const inicialFilme = {
        classificacaoIndicativa: '',
        lancamento: '',
        titulo: '',
    }

    const [filme, setFilme] = useState(inicialFilme);
    const { id } = useParams();

    useEffect(() => {
        const getFilme = async () => {
            await api.get(`/Filme/${id}`)
                .then(response => {
                    setFilme(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getFilme();
    }, [id]);
    
    return (
        <FormRow
            obj={filme}
            operacao={"Consultar"}
        />
    )
}

function Atualizar() {
    const inicialFilme = {
        classificacaoIndicativa: '',
        lancamento: '',
        titulo: '',
    }

    const [filme, setFilme] = useState(inicialFilme);
    const handleChange = event => {
        setFilme({ filme: methods.changeStateObj(event, filme) });
    }
    
    const { id } = useParams();

    useEffect(() => {
        const getFilme = async () => {
            await api.get(`/Filme/${id}`)
                .then(response => {
                    setFilme(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getFilme();
    }, [id]);

    const history = useNavigate();
    const handleSubmit = async () => {
        await api.put('/Filme', filme)
            .then(res => {
                console.log(res.data)
                history('/filme');
            })
            .catch(function (error) {
                console.log(error);
            })
    }

    return (
        <FormRow
            obj={filme}
            operacao={"Atualizar"}
            handleChange={handleChange}
            onSubmit={handleSubmit}
        />
    )
}

function Excluir() {
    
    const inicialFilme = {
        classificacaoIndicativa: '',
        lancamento: '',
        titulo: '',
    }

    const [filme, setFilme] = useState(inicialFilme);
    const { id } = useParams();

    useEffect(() => {
        const getFilme = async () => {
            await api.get(`/Filme/${id}`)
                .then(response => {
                    setFilme(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getFilme();
    }, [id]);

    const history = useNavigate();
    const handleSubmit = async () => {
        await api.delete(`/Filme/${id}`)
            .then(res => {
                console.log(res.data)
                history('/filme');
            })
            .catch(function (error) {
                console.log(error);
            })
    }
    
    return (
        <FormRow
            obj={filme}
            operacao={"Excluir"}
            onSubmit={handleSubmit}
        />
    )
}

const exportedObject = {
    Index, Cadastrar, Consultar, Atualizar, Excluir
};

export default exportedObject;