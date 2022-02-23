import React from 'react';
import { Link } from 'react-router-dom';
import { creditService } from '../../services/credit.service';

class HomePage extends React.Component {

    constructor(props) {
        super(props);

        this.state = { loading: false };

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async handleSubmit(e) {
        e.preventDefault();
        this.setState({ loading: true });
        const res = await creditService.getCredit({
            id: e.target[0].value,
            name: e.target[1].value,
            surname: e.target[2].value,
            email: e.target[3].value,
            phone: e.target[4].value,
            monthlyIncome: e.target[5].value
        });
        this.setState({ loading: false, res: res });
    }

    render() {
        return (
            <div className="col-md-9 col-md-offset-2">
                <Link to="/login" style={{float: 'right'}}>Logout</Link>
                <h1>Hi !</h1>
                <p>Welcome to Credit System!</p>
                <h3>Fill out the form to find out your credit limit.</h3>
                <br />
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group row">
                        <label htmlFor="inputID" className="col-sm-4 col-form-label">ID</label>
                        <div className="col-sm-8">
                            <input type="number" className="form-control" id="inputID" placeholder="ID" required defaultValue={11011011011} />
                        </div>
                    </div>
                    <div className="form-group row">
                        <label htmlFor="inputName" className="col-sm-4 col-form-label">Name</label>
                        <div className="col-sm-8">
                            <input className="form-control" id="inputName" placeholder="Name" required defaultValue="ibrahim" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <label htmlFor="inputSurname" className="col-sm-4 col-form-label">Surname</label>
                        <div className="col-sm-8">
                            <input className="form-control" id="inputSurname" placeholder="Surname" required defaultValue="AKIN" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <label htmlFor="inputEmail" className="col-sm-4 col-form-label">Email</label>
                        <div className="col-sm-8">
                            <input type="email" className="form-control" id="inputEmail" placeholder="Email" defaultValue="credit@system.com" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <label htmlFor="inputPhone" className="col-sm-4 col-form-label">Phone Number</label>
                        <div className="col-sm-8">
                            <input className="form-control" id="inputPhone" placeholder="Phone Number" required defaultValue="+905412345678" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <label htmlFor="inputIncome" className="col-sm-4 col-form-label">Monthly Income</label>
                        <div className="col-sm-8">
                            <input type="number" min={0} step={0.01} className="form-control" id="inputIncome" placeholder="Monthly Income" required defaultValue={6000} />
                        </div>
                    </div>
                    <div className="form-group row">
                        <div className="col-sm-10">
                            <button type="submit" className="btn btn-primary" disabled={this.state.loading}>Check</button>
                            {this.state.loading &&
                                <img alt="logo" style={{ marginLeft: 10 }}
                                    src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
                            }
                        </div>
                    </div>
                </form>
                <div style={{ height: 60 }}>
                    {this.state.res &&
                        <div className={`alert ${this.state.res.result ? 'alert-success': 'alert-danger'}`}>
                            {this.state.res.message}
                            {this.state.res.amount > 0 && <><b> Amout : </b><span className="h3">{this.state.res.amount}</span></>}
                        </div>
                    }
                </div>
            </div>
        );
    }
}

export { HomePage as Home };