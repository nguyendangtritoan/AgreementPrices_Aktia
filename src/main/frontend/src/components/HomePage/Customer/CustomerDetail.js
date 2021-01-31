import "./Customer.css";
import {AGREEMENT_BY_CUSTOMER_ID} from "../../const/apiConst"
import {useParams} from "react-router-dom"
import {useEffect, useState} from "react"
import axios from 'axios'

const CustomerDetail = (props) => {

    useEffect(() => {
        fetchData();
    }, [])

    const {id} = useParams();
    const [agreements, setAgreements] = useState([])

    const fetchData = async () => {
        const data = await axios(AGREEMENT_BY_CUSTOMER_ID + id);
        setAgreements(data.data)
    }


    return (
        <div className="customers">
                {agreements.length !== 0 ?
                    agreements.map((agreement, key) =>
                        (<div className="customer">
                            <div className="info"> - Id: {agreement.id}</div>
                            <div className="info"> - Customer name: {agreement.customerEntity.name}</div>
                            <div className="info"> - Customer id number: {agreement.customerEntity.idNumber}</div>
                            <div className="info"> - Type: {agreement.typeAgreement}</div>
                            <div className="info"> - Start: {agreement.startAgreement}</div>
                            <div className="info"> - End: {agreement.endAgreement}</div>
                        </div>))
                    :
                <div className="customer">
                    <div className="info">THIS USER DOES NOT HAVE ANY AGREEMENT</div>
                </div>
                }
        </div>
    );
}

export default CustomerDetail;
