import React from 'react';

export default function FormRow(props) {

    const { nome, CPF, dataNascimentoFormatado } = props.obj;
    const operacao = props.operacao;
    return (
        <>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 corpo">
                    <h1>{operacao} Cliente</h1>
                </div>
                <div className="col-sm-2"></div>
            </div>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 text-left corpo">
                    <form onSubmit={props.onSubmit}>
                        <div className="form-group">
                            <label>Nome do Cliente: </label>
                            <input
                                type="text"
                                className="form-control"
                                defaultValue={nome}
                                onChange={props.handleChange}
                                readOnly={!props.handleChange}
                            />
                        </div>
                        <div className="form-group">
                            <label>CPF do Cliente: </label>
                            <input
                                type="text"
                                className="form-control"
                                defaultValue={CPF}
                                onChange={props.handleChange}
                                readOnly={!props.handleChange}
                            />
                        </div>
                        <div className="form-group">
                            <label>Data de Nascimento:</label>
                            <input
                                type="date"
                                className="form-control"
                                defaultValue={dataNascimentoFormatado}
                                onChange={props.handleChange}
                                readOnly={!props.handleChange}
                            />
                        </div>
                        {
                            operacao !== "Consultar" ?
                                <input
                                    type="submit"
                                    className="btn btn-default"
                                    value={`${operacao} cliente`}
                                /> : <></>
                        }
                    </form>
                </div>
                <div className="col-sm-2 "></div>
            </div>
        </>
    )
}