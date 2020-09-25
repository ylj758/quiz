import React, {Component} from 'react'
import './Order.css';

class Order extends Component {
  state = {
    orders: {},
  };

  async componentDidMount() {
    const result = await fetch("http://localhost:8080/orders");
    const data = await result.json();
    this.setState({
      orders: data
    });
  }

  handleDelete = (id, e) => {
    // const result = fetch ("http://localhost:8080/order/delete/"+id);
    // console.log(result)
    // const data = result.json();
    // console.log(result)
  }

render()
{
  return (
    <div className="order">
      <table className="table">
        <tbody>
        <tr>
          <th>名字</th>
          <th>单价</th>
          <th>数量</th>
          <th>单位</th>
          <th>操作</th>
        </tr>
        {
          Object.values(this.state.orders).map((order, index) => {
            return <tr key={index}>
              <td>{order.name}</td>
              <td>{order.price}</td>
              <td>{order.count}</td>
              <td>{order.unit}</td>
              <td>
                <button type="button" onClick={(e) => this.handleDelete(order.id, e)}>删除</button>
              </td>
            </tr>
          })
        }
        </tbody>
      </table>

    </div>
  );

}
}

export default Order;