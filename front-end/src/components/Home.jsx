import React, {Component} from 'react'
import './Home.css';
import {Table,Modal,Button} from 'antd';
import Cart from '../images/cart.png'

class Home extends Component {
  state = {
    products: {},
    cartNum: 0,
    visible:false,
    cartProducts:[]
  };

  async componentDidMount() {
    const result = await fetch("http://localhost:8080/products");
    const data = await result.json();
    this.setState({
      products: data
    });
  }

  async handleAddCart(e, product) {
    this.setState({
      cartNum: this.state.cartNum + 1,
      cartProducts: this.state.cartProducts.push(product)
    });

  }

  showCartModal() {
    this.setState({
      visible: true
    })
  }

  async handleAddOrder(products){
    const response = await fetch("http://localhost:8080/order/add",{
      method:"POST",
      headers: {
        'Content-Type': 'application/json'
      },
      body:JSON.stringify(products)
    })
  }

  columns = [
    {
      title: '商品',
      dataIndex: 'name',
      key: 'name'
    },

    ]

  render() {

    return (
      <div className="home">
        {
          Object.values(this.state.products).map((product, index) => {
            return <div key={index} className="pro-div">
              <img src={product.img}></img>
              <p className="pro-name">{product.name}</p>
              <p className="pro-price">单价：{product.price}{product.unit}</p>
              <input type="submit" value="+" className="link-order"
                     key={index} onClick={(e, product) => this.handleAddCart(e, product)}></input>
            </div>
          })
        }
        <div className="cart">
          <Button onClick={(e) => this.showCartModal(e)} className="cancel-btn">
            <img className="cartImg" src={Cart}></img>
            <label className="cartNum">{this.state.cartNum}</label>
          </Button>
          <Modal
            title="购物车"
            footer={null}
            visible={this.state.visible}
            width={400}
            onCancel={() => this.setState({visible: false})}
          >
            <div className="modal-body">
              <Table
                columns={this.columns}
                rowKey="id"
                dataSource={this.state.cartProducts}
                className="order-table"
              />

              <div className="btn-group">
                <Button onClick={() => this.handleAddOrder(this.state.cartProducts)} >立即下单</Button>
                <Button onClick={() => this.setState({cartProducts:[]})} >清空</Button>
              </div>
            </div>
          </Modal>
        </div>
      </div>
    );
  }

}


export default Home;