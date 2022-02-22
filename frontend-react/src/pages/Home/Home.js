import React from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import { userActions } from '../../store/actions/user.actions';

class HomePage extends React.Component {

    componentDidMount() {
        this.props.getUsers();
    }

    handleDeleteUser(id) {
        return e => this.props.deleteUser(id);
    }

    render() {
        const { user } = this.props;
        return (
            <div className="col-md-9 col-md-offset-2">
                <h1>Hi {user.firstName}!</h1>
                <p>You're logged in with React!!</p>
                <h3>Fill out the form to find out your credit limit.</h3>
                
                <p>
                    <Link to="/login">Logout</Link>
                </p>
            </div>
        );
    }
}

function mapState(state) {
    const { users, authentication } = state;
    const { user } = authentication;
    return { user, users };
}

const actionCreators = {
    getUsers: userActions.getAll,
    deleteUser: userActions.delete
}

const connectedHomePage = connect(mapState, actionCreators)(HomePage);
export { connectedHomePage as Home };