import "./Customer.css";
import {Link} from "react-router-dom"
import axios from "axios";
import {CUSTOMERS} from "../../const/apiConst";
import {useEffect, useState} from "react";


const Customer = props => {

    const [customers, setCustomers] = useState([])

    const fetchData = async () => {
        await axios(
            CUSTOMERS,
        ).then((resp) => {
            setCustomers(resp.data);
        }).catch(setCustomers([]))
    };

    useEffect(() => {
        fetchData();
    }, [])

    return (
        <div className="customers">
            {customers.map((customer, key) => (
                <div className="customer" key={key}>
                    <p> Customer {key + 1} </p>
                    <div className="photo">{customer.name[0]}</div>
                    <div className="name">Name: {customer.name}</div>
                    <div className="idNumber">Id number: {customer.idNumber}</div>
                    <div className="id">ID: {customer.id}</div>
                    <Link to={`/agreementDetail/${customer.id}`}>
                        <button className="btn">
                            AGREEMENT DETAIL
                        </button>
                    </Link>
                </div>)
            )
            }
        </div>
    );
}

export default Customer;
