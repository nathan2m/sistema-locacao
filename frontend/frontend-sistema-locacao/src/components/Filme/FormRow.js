import React from 'react';

export default function FormRow(props) {

    const { titulo, classificacaoIndicativa, lancamento } = props.obj;
    const operacao = props.operacao;
    return (
        <>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 corpo">
                    <h1>{operacao} Filme</h1>
                </div>
                <div className="col-sm-2"></div>
            </div>
            <div className="col-sm-12 ">
                <div className="col-sm-2 "></div>
                <div className="col-sm-8 text-left corpo">
                    <form onSubmit={props.onSubmit}>
                        <div className="form-group">
                            <label>Título do Filme: </label>
                            <input 
                                type="text" 
                                className="form-control"  
                                defaultValue={titulo}
                                onChange={props.handleChange}
                                readOnly={!props.handleChange} 
                            />
                        </div>
                        <div className="form-group">
                            <label>Classificação Indicativa do Filme: </label>
                            <select 
                                className="form-control"
                                value={classificacaoIndicativa} 
                                onChange={props.handleChange}
                                readOnly={!props.handleChange} 
                            >
                                <option value=""></option>
                                <option value="0">L</option>
                                <option value="10">10</option>
                                <option value="12">12</option>
                                <option value="14">14</option>
                                <option value="16">16</option>
                                <option value="18">18</option>
                            </select>
                        </div>
                        <div className="form-group">
                            <label>Filme é Lançamento?</label>
                            <select 
                                className="form-control"
                                value={lancamento} 
                                onChange={props.handleChange}
                                readOnly={!props.handleChange} 
                            >
                                <option value=""></option>
                                <option value="1">Sim</option>
                                <option value="0">Não</option>
                            </select>
                        </div>
                        {
                            operacao !== "Consultar" ?
                                <input
                                    type="submit"
                                    className="btn btn-default"
                                    value={`${operacao} filme`}
                                /> : <></>
                        }
                    </form>    
                </div>    
                <div className="col-sm-2 "></div>
            </div >
        </>
    )
}