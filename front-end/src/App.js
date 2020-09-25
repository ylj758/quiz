import React from 'react';
import './App.css';
import {BrowserRouter, Route, Switch, NavLink} from 'react-router-dom';
import Product from './components/Products'
import Home from './components/Home'
import Order from './components/Order'

function App() {
  return (
    <div className="App">
        <BrowserRouter>
          <header className="header">
            <NavLink to="/" className="link">商城</NavLink>
            <NavLink to="/order" className="link">订单</NavLink>
            <NavLink to="/product" className="link">添加商品</NavLink>
          </header>
          <Switch>
            <Route exact path='/' component={Home}/>
            <Route exact path='/order' component={Order}/>
            <Route exact path='/product' component={Product}/>
          </Switch>
        </BrowserRouter>
    </div>
  );
}

export default App;
