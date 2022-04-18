import React from 'react';
import { Link } from 'react-router-dom';

function TableRow(props) {

    const { id, nome } = props.obj;
    return (
        <tr>
            <td>{id}</td>
            <td>{nome}</td>
            <td>
                <Link to={`/cliente/consultar/${id}`} title="Consultar">
                    <span className="glyphicon glyphicon-eye-open"></span>
                </Link>
            </td>
            <td>
                <Link to={`/cliente/atualizar/${id}`} title="Atualizar">
                    <span className="glyphicon glyphicon-edit"></span>
                </Link>
            </td>
            <td>
                <Link to={`/cliente/excluir/${id}`} title="Excluir">
                    <span className="glyphicon glyphicon-trash"></span>
                </Link>
            </td>
        </tr>
    );

}

export default TableRow;