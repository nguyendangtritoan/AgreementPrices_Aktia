import "./Agreement.css";
import {Link} from "react-router-dom"
import axios from "axios";
import {AGREEMENTS, SUM_OF_FEE} from "../../const/apiConst";
import {useEffect, useState} from "react";


const Agreement = (props) => {

    const [agreements, setAgreements] = useState([])
    const [feeOfSum, setFeeOfSum] = useState([])

    const getSumOfFee = async (agreementId) => {
        const result = await axios(SUM_OF_FEE + agreementId)
        return result.data
    }

    const fetchData = async () => {
        const result = await axios(AGREEMENTS,)
        return result.data
    };


    useEffect(() => {
        fetchData().then(async r => {
            let length = r.length;
            let array = []
            r.map((agreement,key) => {
                getSumOfFee(agreement.id).then(r => {array[key] = r; if(key === length-1) setFeeOfSum(array)})
            })
            setAgreements(r);
        });

    }, [])

    return (
        <div className="agreements">
            {agreements.length !== 0 ?
                agreements.map((agreement, key) => (
                    <div className="agreement">
                        {agreement !== null && <>
                            <p className="info"> Agreement {key+1} </p>
                            <div className="info"> - Id: {agreement.id}</div>
                            <div className="info"> - Customer name: {agreement.customerEntity.name}</div>
                            <div className="info"> - Customer id number: {agreement.customerEntity.idNumber}</div>
                            <div className="info"> - Type: {agreement.typeAgreement}</div>
                            <div className="info"> - Start: {agreement.startAgreement}</div>
                            <div className="info"> - End: {agreement.endAgreement}</div>
                            <div className="info"> - Total fee: {feeOfSum[key]}</div>
                        </>}
                    </div>))
                :
                <div className="agreement">
                    <div className="info">THIS USER DOES NOT HAVE ANY AGREEMENT</div>
                </div>}
        </div>
    );
}

export default Agreement;
