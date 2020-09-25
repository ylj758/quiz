import React, {Component} from 'react';
import "bootstrap/dist/css/bootstrap.css";


class About extends Component {
  state = {
    name: "",
    price: "",
    unit: "",
    img: "",
  };
  handleFileChange = (field, event) => {
    this.setState({
      [field]: event.target.value,
    })
  };
  handleFormSubmit = (e) => {
    e.preventDefault();
    alert(JSON.stringify(this.state));
  }


  render() {
    return (
      <div className="products">
        <form className="my-form">
          <div className="form-group">
            <p>名称</p>
            <input
              type="text"
              value={this.state.name}
              onChange={(e) => this.handleFileChange("name", e)}
              className="form-control input-name"
              id="name"
              placeholder={"名称"}
            >
            </input>
          </div>

          <div className="form-group">
            <p>价格</p>
            <input
              type="text"
              value={this.state.price}
              onChange={(e) => this.handleFileChange("price", e)}
              className="form-control input-name"
              id="price"
              placeholder={"价格"}
            >
            </input>
          </div>
          <div className="form-group">
            <p>单位</p>
            <input
              type="text"
              value={this.state.unit}
              onChange={(e) => this.handleFileChange("unit", e)}
              className="form-control input-name"
              id="unit"
              placeholder={"单位"}
            >
            </input>
          </div>
          <div className="form-group">
            <p>图片</p>
            <input
              type="text"
              value={this.state.img}
              onChange={(e) => this.handleFileChange("img", e)}
              className="form-control input-name"
              id="img"
              placeholder={"URL"}
            >
            </input>
          </div>

        </form>
        <input type="submit"
               value="submit"
               className="btn btn-primary input-btn"
               disabled={!this.state.name || !this.state.img || !this.state.price|| !this.state.unit}
               onClick={this.handleFormSubmit}
        />
      </div>
    );
  }
}

export default About;