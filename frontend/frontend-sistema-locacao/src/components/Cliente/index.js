import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import api from '../../services/api';
import FormRow from './FormRow';
import TableRow from './TableRow';

const methods = require('../functions');

function Index() {
    const [clientes, setClientes] = useState([]);

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
    }, []);

    return (
        <>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 corpo">
                    <h1>Pesquisa de Clientes</h1>
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
                                    <th>Id Cliente</th>
                                    <th>Nome Cliente</th>
                                    <th colSpan="3">Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                {clientes.map((cliente, i) => <TableRow obj={cliente} key={i} />)}
                            </tbody>
                        </table>
                    </div>
                    <Link to={'/cliente/cadastrar'} className="btn btn-default">Cadastrar Cliente</Link>
                </div>
                <div className="col-sm-2"></div>
            </div>
        </>
    );
}

function Cadastrar() {
    const inicialCliente = {
        nome: '',
        CPF: '',
        dataNascimento: '',
    }

    const [cliente, setCliente] = useState(inicialCliente);

    const handleChange = event => {
        setCliente({ cliente: methods.changeStateObj(event, cliente) });
    }

    const history = useNavigate();
    const handleSubmit = async () => {
        await api.post('/Cliente', cliente)
            .then(res => {
                console.log(res.data)
                history('/cliente');
            })
            .catch(function (error) {
                console.log(error);
            })
    }


    return (
        <FormRow
            obj={cliente}
            operacao={"Cadastrar"}
            handleChange={handleChange}
            onSubmit={handleSubmit}
        />
    )

}

function Consultar() {

    const inicialCliente = {
        nome: '',
        CPF: '',
        dataNascimentoFormatado: '',
    }

    const [cliente, setCliente] = useState(inicialCliente);
    const { id } = useParams();

    useEffect(() => {
        const getCliente = async () => {
            await api.get(`/Cliente/${id}`)
                .then(response => {
                    setCliente(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getCliente();
    }, [id]);

    return (
        <FormRow
            obj={cliente}
            operacao={"Consultar"}
        />
    )

}

function Atualizar() {

    const inicialCliente = {
        nome: '',
        CPF: '',
        dataNascimento: '',
    }

    const [cliente, setCliente] = useState(inicialCliente);
    const handleChange = event => {
        setCliente({ cliente: methods.changeStateObj(event, cliente) });
    }

    const { id } = useParams();

    useEffect(() => {
        const getCliente = async () => {
            await api.get(`/Cliente/${id}`)
                .then(response => {
                    setCliente(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getCliente();
    }, [id]);

    const history = useNavigate();
    const handleSubmit = async () => {
        await api.put('/Cliente', cliente)
            .then(res => {
                console.log(res.data)
                history('/cliente');
            })
            .catch(function (error) {
                console.log(error);
            })
    }

    return (
        <FormRow
            obj={cliente}
            operacao={"Atualizar"}
            handleChange={handleChange}
            onSubmit={handleSubmit}
        />
    )
}

function Excluir() {
    const inicialCliente = {
        nome: '',
        CPF: '',
        dataNascimento: '',
    }

    const [cliente, setCliente] = useState(inicialCliente);
    const { id } = useParams();

    useEffect(() => {
        const getCliente = async () => {
            await api.get(`/Cliente/${id}`)
                .then(response => {
                    setCliente(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
        getCliente();
    }, [id]);

    const history = useNavigate();
    const handleSubmit = async () => {
        await api.delete(`/Cliente/${id}`)
            .then(res => {
                console.log(res.data)
                history('/cliente');
            })
            .catch(function (error) {
                console.log(error);
            })
    }  

    return (
        <FormRow
            obj={cliente}
            operacao={"Excluir"}
            onSubmit={handleSubmit}
        />
    )
}

const exportedObject = {
    Index, Cadastrar, Consultar, Atualizar, Excluir
};

export default exportedObject;