import React from 'react';

import { Routes, Route } from 'react-router-dom';
import Cliente from './components/Cliente';
import Filme from './components/Filme';
import Inicio from './components/structure/Inicio';
import Locacao from './components/Locacao';
import Relatorio from './components/Relatorio';

const Rotas = () => (
    <Routes>
        <Route path='/cliente' element={<Cliente.Index />} />
        <Route path='/cliente/cadastrar' element={<Cliente.Cadastrar />} />
        <Route path='/cliente/consultar/:id' element={<Cliente.Consultar />} />
        <Route path='/cliente/atualizar/:id' element={<Cliente.Atualizar />} />
        <Route path='/cliente/excluir/:id' element={<Cliente.Excluir />} />

        <Route path='/filme' element={<Filme.Index />} />
        <Route path='/filme/cadastrar' element={<Filme.Cadastrar />} />
        <Route path='/filme/consultar/:id' element={<Filme.Consultar />} />
        <Route path='/filme/atualizar/:id' element={<Filme.Atualizar />} />
        <Route path='/filme/excluir/:id' element={<Filme.Excluir />} />

        <Route path='/locacao' element={<Locacao.Index />} />
        <Route path='/locacao/cadastrar' element={<Locacao.Cadastrar />} />
        <Route path='/locacao/consultar/:id' element={<Locacao.Consultar />} />
        <Route path='/locacao/atualizar/:id' element={<Locacao.Atualizar />} />
        <Route path='/locacao/excluir/:id' element={<Locacao.Excluir />} />

        <Route path='/relatorio' element={<Relatorio />} />

        <Route exact path='/' element={<Inicio />} />
    </Routes>
);

export default Rotas;