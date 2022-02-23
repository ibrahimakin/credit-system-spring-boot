import { authHeader } from '../helpers/auth-header';
import { handleResponse } from './user.service';

export const creditService = { getCredit };

function getCredit(data) {
    const requestOptions = {
        method: 'POST',
        headers: { ...authHeader(), 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    };
    return fetch(`http://localhost:8080/credit`, requestOptions)
        .then(handleResponse).catch(err => ({ message: err }));
}