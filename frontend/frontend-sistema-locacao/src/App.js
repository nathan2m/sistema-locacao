import React from 'react';

import Menu from './components/structure/Menu';
import Rodape from './components/structure/Rodape';
import Routes from './routes';

import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
        <Menu />
        <div className="conteudo">
          <div className="container-fluid text-center">
            <div className="row content">
              <Routes/>
            </div>
          </div>
        </div>
        <Rodape />
    </BrowserRouter>
  );
}

export default App;
