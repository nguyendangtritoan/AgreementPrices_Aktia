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
                "typeAgreement": parseInt(agreementType),
                "startAgreement": startDate.replace("T", " "),
                "endAgreement": endDate.replace("T", " ")
            },
            "typeService": parseInt(typeService),
            "feeService": parseInt(feeService)
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
                    <form onSubmit={handleUpdateService}>
                        <input required={true} name="id" placeholder="Id of service" value={serviceId}
                               onChange={e => setServiceId(e.target.value)} />
                        <br />
                        <input required={true} name="customerIdNumber" placeholder="customer ID number"
                               value={customerIdNumber}
                               onChange={e => setCustomerIdNumber(e.target.value)} />
                        <br />
                        <input required={true} name="customerName" placeholder="Customer name" value={customerName}
                               onChange={e => setCustomerName(e.target.value)} />
                        <br />
                        <input required={true} name="agreementType" placeholder="Agreement type" value={agreementType}
                               onChange={e => setAgreementType(e.target.value)} />
                        <br />
                        <input required={true} type="datetime-local" name="end" step="1" value={startDate}
                               onChange={e => setStartDate(e.target.value)} />
                        <br />
                        <input type="datetime-local" name="end" step="1" value={endDate}
                               onChange={e => setEndDate(e.target.value)} />
                        <br />
                        <input required={true} name="typeService" placeholder="Service type" value={typeService}
                               onChange={e => setTypeService(e.target.value)} />
                        <br />
                        <input required={true} name="feeService" placeholder="Service fee" value={feeService}
                               onChange={e => setFee(e.target.value)} />
                        <br />
                        <input type="submit"/>
                    </form>
                </div>
            </div>
            <p style={{"color": "green"}}>{isSuccess === "1" ? "Updated" : ""}</p>
        </>
    )
}

export default UpdateComponent