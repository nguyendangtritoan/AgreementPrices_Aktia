import "./Agreement.css";
import {Link} from "react-router-dom"
import axios from "axios";
import {AGREEMENTS, DELETE_AGREEMENT, SUM_OF_FEE} from "../../const/apiConst";
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

    const handleDelete = async (id, key) => {
        console.log(id, key)
        await axios.delete(DELETE_AGREEMENT+id).then(() => {
            const newList = agreements.filter((agreement) => agreement.id !== id);
            setAgreements(newList)
        })
    }


    useEffect(() => {
        fetchData().then(async r => {
            let length = r.length;
            let array = []
            r.map((agreement,key) => {
                getSumOfFee(agreement.id).then(r => {
                    array[key] = r;
                    if(key === length-1)
                        setFeeOfSum(array)
                })
            })
            setAgreements(r);
        });

    },[])

    return (
        <div className="agreements">
            {agreements.length !== 0 ?
                agreements.map((agreement, key) => (
                    <div className="agreement" key={key}>
                        {agreement !== null && <>
                            <p className="info"> Agreement {key+1} </p>
                            <div className="info"> - Id: {agreement.id}</div>
                            <div className="info"> - Customer name: {agreement.customerEntity.name}</div>
                            <div className="info"> - Customer id number: {agreement.customerEntity.idNumber}</div>
                            <div className="info"> - Type: {agreement.typeAgreement}</div>
                            <div className="info"> - Start: {agreement.startAgreement}</div>
                            <div className="info"> - End: {agreement.endAgreement}</div>
                            <div className="info"> - Total fee: {feeOfSum[key]}</div>
                            <button className="btn-del" onClick={() => handleDelete(agreement.id, key)}>Delete</button>
                        </>}
                    </div>))
                :
                <div className="agreement">
                    <div className="info">THERE IS NO AGREEMENT EXIST</div>
                </div>}
        </div>
    );
}

export default Agreement;
