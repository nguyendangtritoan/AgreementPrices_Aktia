import axios from "axios";
import {ADD_AGREEMENT, ADD_CUSTOMER, ADD_SERVICE, UPDATE_SERVICE} from "../../const/apiConst";
import "../HomePage.css"
import {useState} from "react";

function UpdateComponent(props) {

    const [serviceId, setServiceId] = useState("")
    const [customerIdNumber, setCustomerIdNumber] = useState("")
    const [customerName, setCustomerName] = useState("")
    const [agreementType, setAgreementType] = useState("")
    const [startDate, setStartDate] = useState("")
    const [endDate, setEndDate] = useState("")
    const [typeService, setTypeService] = useState("")
    const [feeService, setFee] = useState("")

    const [isSuccess, setSuccess] = useState("")

    const handleUpdateService = async (e) => {
        e.preventDefault();
        await axios.put(UPDATE_SERVICE, {
            "id": serviceId,
            "agreementEntity": {
                "customerEntity": {
                    "idNumber": customerIdNumber,
                    "name": customerName
                },
                "typeAgreement": agreementType,
                "startAgreement": startDate.replace("T", " "),
                "endAgreement": endDate.replace("T", " ")
            },
            "typeService": typeService,
            "feeService": feeService
        }).then(r => {
            if (r.data.id !== null) {
                setSuccess("1");
                setServiceId("")
                setCustomerIdNumber("")
                setCustomerName("")
                setAgreementType("")
                setStartDate("")
                setEndDate("")
                setTypeService("")
                setFee("")
            }
        })

    }

    return (
        <>
            <div className="updateSection">
                <div className="formSection">
                    <h3> Update service </h3>
                    <form>
                        <input required name="id" placeholder="Id of service" value={serviceId}
                               onChange={e => setServiceId(e.target.value)} />
                        <br />
                        <input required name="customerIdNumber" placeholder="customer ID number"
                               value={customerIdNumber}
                               onChange={e => setCustomerIdNumber(e.target.value)} />
                        <br />
                        <input required name="customerName" placeholder="Customer name" value={customerName}
                               onChange={e => setCustomerName(e.target.value)} />
                        <br />
                        <input required name="agreementType" placeholder="Agreement type" value={agreementType}
                               onChange={e => setAgreementType(e.target.value)} />
                        <br />
                        <input required type="datetime-local" name="end" step="1" value={startDate}
                               onChange={e => setStartDate(e.target.value)} />
                        <br />
                        <input type="datetime-local" name="end" step="1" value={endDate}
                               onChange={e => setEndDate(e.target.value)} />
                        <br />
                        <input required name="typeService" placeholder="Service type" value={typeService}
                               onChange={e => setTypeService(e.target.value)} />
                        <br />
                        <input required name="feeService" placeholder="Service fee" value={feeService}
                               onChange={e => setFee(e.target.value)} />
                        <br />
                        <input type="submit" onClick={e => handleUpdateService(e)} />
                    </form>
                </div>
            </div>
            <p style={{"color": "green"}}>{isSuccess === "1" ? "Updated" : ""}</p>
        </>
    )
}

export default UpdateComponent