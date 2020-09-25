import React, {Component} from 'react'
import './Home.less';

class Home extends Component {
  state = {
    products: {},
  };

  async componentDidMount(){
    const result = await fetch("http://localhost:3000/products");
    const data = await result.json();
    this.setState({
      phones:data
    });
  }
  render() {
    return (
      <div className="home">

      </div>
    );
  }

}


export default Home;