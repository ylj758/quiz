import React, {Component} from 'react'
import './Home.css';
import {Link} from 'react-router-dom';

class Home extends Component {
  state = {
    products: {},
  };

  async componentDidMount(){
    const result = await fetch("http://localhost:8080/products");
    const data = await result.json();
    this.setState({
      products:data
    });
  }
  render() {
    return (
      <div className="home">
        {
          Object.values(this.state.products).map((product,index) =>{
            return <div key={index} className="pro-div">
              <img src = {product.img}></img>
              <p className="pro-name">{product.name}</p>
              <p className="pro-price">单价：{product.price}{product.unit}</p>
              <input type="submit" value="+" className="link-order"
                    key={index}></input>
            </div>
          } )
        }
      </div>
    );
  }

}


export default Home;