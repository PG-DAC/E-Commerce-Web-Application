import { useState } from 'react'
import React, { useEffect } from 'react'
import "./index.css"
import { useNavigate } from 'react-router'
const Product = (props) => {
    const navigate = useNavigate()
    const { product } = props
    console.log(product.productImage);



    const forward = () => {
        sessionStorage['productId'] = product.productId
        sessionStorage['productName'] = product.productName
        sessionStorage['productDescription'] = product.productDescription
        sessionStorage['productImage'] = product.productImage
        sessionStorage['productPrice'] = product.productPrice
        sessionStorage['productDiscount'] = product.productDiscount
        sessionStorage['productFinalPrice'] = product.productFinalPrice
        sessionStorage['productQuantity'] = product.productQuantity
        navigate('/productdetails')
        
    }



    return (<div className='col-11 col-md-6 col-lg-3 mx-o mb-4' >
    <div id="container" className="card p-0 overflow-hidden h-100 shadow">



        <img id="pimg" src={product.productImage} className="card-img-top img-fluid" />

        <div className="card-body text-center" > 

        </div>
        <div >
            <h6 className="card-title" style={{color:"black",minHeight: "50px",
  maxHeight: "50px"}}>{product.productName}</h6>

            <div class="item-detail" style={{ minHeight: "60px", maxheight: "60px",backgroundColor:"white" }}>



                <div class="item-price" >
                    <span class="new-price" style={{ fontWeight: "bold", fontSize: "18px",paddingLeft:"18px" }}>₹{product.productFinalPrice}</span>
                    <span class="old-price" style={{ textDecoration: "line-through", paddingLeft: "80px",paddingRight:"10px", color: "grey", fontWeight: "bold", fontSize: "16px" }}>₹{product.productPrice}</span>
                    <div class="_3Ay6Sb" style={{ fontWeight: "bold", fontSize: "18px", fontWeight: "bold", textAlign: "center", color: "green" }}><span>{product.productDiscount}% off</span></div>

                </div>
                
            </div>
        </div>
        <button type="button" onClick={forward} className="btn btn-success float-right" >Details</button>
    </div>
</div>

)



}

export default Product