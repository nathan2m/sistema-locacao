import React from 'react';

import { Link } from 'react-router-dom';

function Rodape() {
    return (
        <div className="rodape">
            <footer className="container-fluid text-center">
                <div className="col-sm-2"></div>
                <div className="col-sm-4 text-left">
                    <p><b>Mapa do Sistema:</b></p>
                    <p><Link to={'/'}>Início</Link></p>
                    <p><Link to={'/cliente'} >Clientes</Link></p>
                    <p><Link to={'/filme'} >Filmes</Link></p>
                    <p><Link to={'/locacao'} >Locações</Link></p>
                    <p><Link to={'/relatorio'} >Relatórios</Link></p>
                    <br />
                </div>
                <div className="col-sm-6 text-left">
                    <div className="col-sm-9 text-left">
                        <p><b>Descrição:</b></p>
                        <p>Sistema de gestão de locações de filmes.</p>
                        <br />
                    </div>
                </div>
            </footer>
        </div>
    );
}

export default Rodape;