import React from 'react';

import { Link } from 'react-router-dom';

function Menu() {
    return (
        <div className="topo">
            <nav className="navbar navbar-inverse">
                <div className="container-fluid">
                    <div className="navbar-header">
                        <button type="button" className="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                        </button>
                        {/* <a className="navbar-brand" style="cursor:default;"></a> */}
                    </div>
                    <div className="collapse navbar-collapse" id="myNavbar">
                        <ul className="nav navbar-nav">
                            <li><Link to={'/'} >Início</Link></li>
                            <li><Link to={'/cliente'} >Clientes</Link></li>
                            <li><Link to={'/filme'} >Filmes</Link></li>
                            <li><Link to={'/locacao'} >Locações</Link></li>
                            <li><Link to={'/relatorio'} >Relatórios</Link></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    );
}

export default Menu;

