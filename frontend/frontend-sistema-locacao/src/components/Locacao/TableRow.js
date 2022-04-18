import React from 'react';
import { Link } from 'react-router-dom';

function TableRow(props) {
    
    const { id, cliente: { nome }, filme: { titulo }, dataLocacaoFormatado, dataDevolucaoFormatado } = props.obj;
    return (
        <tr>
            <td>{id}</td>
            <td>{nome}</td>
            <td>{titulo}</td>
            <td>{dataLocacaoFormatado}</td>
            <td>{dataDevolucaoFormatado}</td>
            <td>
                <Link to={`/locacao/consultar/${id}`} title="Consultar">
                    <span className="glyphicon glyphicon-eye-open"></span>
                </Link>
            </td>
            <td>
                <Link to={`/locacao/atualizar/${id}`} title="Atualizar">
                    <span className="glyphicon glyphicon-edit"></span>
                </Link>
            </td>
            <td>
                <Link to={`/locacao/excluir/${id}`} title="Excluir">
                    <span className="glyphicon glyphicon-trash"></span>
                </Link>
            </td>
        </tr>
    );
}

export default TableRow;