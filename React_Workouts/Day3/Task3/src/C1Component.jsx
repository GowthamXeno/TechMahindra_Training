import React, { Suspense } from 'react'
import C2Component from './f1/C2Component'

export default function C1Component() {
  return (
    <>
      <Suspense fallback={<h1>Loading.....</h1>}>
        <h1>C1Component</h1>
        <C2Component />
      </Suspense>
    </>
  );
}
